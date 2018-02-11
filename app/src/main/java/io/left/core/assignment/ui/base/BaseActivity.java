package io.left.core.assignment.ui.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

/**
 * Abstract activity that every other Activity in this application must implement.
 */
public abstract class BaseActivity<V extends MvpView, P extends BasePresenter<V>>
        extends AppCompatActivity implements MvpView {

    /**
     * LifecycleRegistry is an implementation of Lifecycle that can handle multiple observers.
     It is used by Fragments and Support Library Activities.
     You can also directly use it if you have a custom LifecycleOwner.
     */
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    protected P presenter;

    /**
     * its built in method in Fragment Activity
     * that is extends by AppCompatActivity
     * @return
     */
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @SuppressWarnings("unchecked")
    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaseViewModel<V, P> viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
        boolean isPresenterCreated = false;
        if (viewModel.getPresenter() == null) {
            viewModel.setPresenter(initPresenter());
            isPresenterCreated = true;
        }
        presenter = viewModel.getPresenter();
        presenter.attachLifecycle(getLifecycle());
        presenter.attachView((V) this);
        if (isPresenterCreated)
            presenter.onPresenterCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachLifecycle(getLifecycle());
        presenter.detachView();
    }

    protected abstract P initPresenter();

}
