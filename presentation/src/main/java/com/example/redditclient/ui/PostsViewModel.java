package com.example.redditclient.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.data.database.RedditDao;
import com.example.domain.model.Children;
import com.example.domain.service.PostService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel extends ViewModel {
    protected Disposable disposable;
    protected MutableLiveData<Boolean> isErrorVisible = new MutableLiveData<>();
    protected MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    protected LiveData<PagedList<Children>> children;
    protected PostsAdapter.OnItemClickListener onItemClickListener;

    @Inject
    RedditDao redditDao;

    @Inject
    PostService postServise;

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = () -> updatePosts();

    @Inject
    public PostsViewModel() {

    }

    public void updatePosts(){
        disposable = postServise
                .getChildren()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> isLoading.postValue(true))
                .doFinally(() -> isLoading.postValue(false))
                .subscribe(
                        response -> {
                            isErrorVisible.postValue(false);
                        },
                        throwable -> {
                            boolean value = children.getValue()==null || children.getValue().size()==0;
                            isErrorVisible.postValue(value);
                        });
    }

    @Override
    public void onCleared(){
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return onRefreshListener;
    }

    public LiveData<PagedList<Children>> getPostsPaged() {
        return new LivePagedListBuilder<>(redditDao.getChildrenPaged(), 5).build();
    }

    public LiveData<PagedList<Children>> getChildren() {
        return children;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<Boolean> getIsErrorVisible() {
        return isErrorVisible;
    }

    public PostsAdapter.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(PostsAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void onAttach() {
        children = getPostsPaged();
        updatePosts();
    }
}
