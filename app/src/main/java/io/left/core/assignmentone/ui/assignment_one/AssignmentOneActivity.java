package io.left.core.assignmentone.ui.assignment_one;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.left.core.assignmentone.data.local.assignment.Assigment;
import io.left.core.assignmentone.ui.base.BaseActivity;
import io.left.core.util.R;


public class AssignmentOneActivity extends BaseActivity<AssignmentOneMvpView,AssignmentOnePresenter> implements AssignmentOneMvpView {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.imageview_user)
    ImageView imageviewUser;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.layout_relative)
    RelativeLayout layoutRelative;

    private LinearLayoutManager mLayoutManager;
    private List<Assigment> mAssigmentList = new ArrayList<>();
    AssigmentAdapter mAdapter;
    boolean isIncrease = false, isScroll = false;

    private int previousIndex ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        ButterKnife.bind(this);

        layoutRelative = (RelativeLayout) findViewById(R.id.layout_relative);

        // for recycler view
        mAdapter = new AssigmentAdapter(mAssigmentList);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        presenter.prepareAssignmentData(mAssigmentList);


        giveAnimation();

    }





    private void giveAnimation() {


        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItemCount = mLayoutManager.findFirstVisibleItemPosition();


                /*
                * for fab icon
                * */

                final Animation animationDownFab = AnimationUtils.loadAnimation(AssignmentOneActivity.this, R.anim.down_fab);
                animationDownFab.setFillEnabled(true);

                final Animation animationUpFab = AnimationUtils.loadAnimation(AssignmentOneActivity.this, R.anim.up_fab);
                animationUpFab.setFillEnabled(true);

                if (isScroll && firstVisibleItemCount == 0 && firstVisibleItemCount != previousIndex) {
                    fab.startAnimation(animationDownFab);
                    isScroll = false;
                } else if (!isScroll && firstVisibleItemCount == 1 && firstVisibleItemCount != previousIndex) {
                    fab.startAnimation(animationUpFab);
                    isScroll = true;
                }


                /*
                * for image
                * */

                final Animation animationZoomOut = AnimationUtils.loadAnimation(AssignmentOneActivity.this, R.anim.zoom_out_scroll_down);
                animationZoomOut.setFillEnabled(true);

                final Animation animationZoomIn = AnimationUtils.loadAnimation(AssignmentOneActivity.this, R.anim.zoom_in_scroll_up);
                animationZoomIn.setFillEnabled(true);
                if (isIncrease && firstVisibleItemCount == 4 && firstVisibleItemCount != previousIndex) {
                    imageviewUser.startAnimation(animationZoomOut);
                    isIncrease = false;
                } else if (!isIncrease && firstVisibleItemCount == 5 && firstVisibleItemCount != previousIndex) {
                    imageviewUser.startAnimation(animationZoomIn);
                    isIncrease = true;
                }

                previousIndex = firstVisibleItemCount;
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

        });

    }


    @Override
    protected AssignmentOnePresenter initPresenter() {
        return new AssignmentOnePresenter();
    }
}
