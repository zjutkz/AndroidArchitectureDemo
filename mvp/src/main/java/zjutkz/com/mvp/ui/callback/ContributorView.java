package zjutkz.com.mvp.ui.callback;


import com.hannesdorfmann.mosby.mvp.MvpView;

import zjutkz.com.mvp.model.Contributor;

/**
 * Created by kangzhe on 16/4/7.
 */
public interface ContributorView extends MvpView {

    void onLoadContributorStart();

    void onLoadContributorComplete(Contributor topContributor);

    void onChangeContributorName(String name);
}
