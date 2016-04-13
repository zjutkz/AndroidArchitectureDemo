package zjutkz.com.mvpdatabinding.ui.callback;


import com.hannesdorfmann.mosby.mvp.MvpView;

import zjutkz.com.mvpdatabinding.viewmodel.Contributor;


/**
 * Created by kangzhe on 16/4/7.
 */
public interface ContributorView extends MvpView {

    void onLoadContributorStart();

    void onLoadContributorComplete(Contributor topContributor);
}
