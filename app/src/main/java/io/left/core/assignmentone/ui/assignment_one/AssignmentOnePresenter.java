package io.left.core.assignmentone.ui.assignment_one;

import java.util.ArrayList;
import java.util.List;

import io.left.core.assignmentone.data.local.assignment.Assigment;
import io.left.core.assignmentone.ui.base.BasePresenter;

/**
 * Created by shameem on 15/01/2018.
 */

public class AssignmentOnePresenter extends BasePresenter<AssignmentOneMvpView> {



    // data generator in recycler view
    public void prepareAssignmentData( List<Assigment> mAssigmentList ) {

        String description="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing";

        for (int i=0;i<=10;i++){
            Assigment assigment = new Assigment(description);
            mAssigmentList.add(assigment);
        }
    }
}
