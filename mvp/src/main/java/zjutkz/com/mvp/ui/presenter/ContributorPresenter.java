package zjutkz.com.mvp.ui.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import zjutkz.com.mvp.api.GitHubApi;
import zjutkz.com.mvp.model.Contributor;
import zjutkz.com.mvp.ui.callback.ContributorView;

/**
 * Created by kangzhe on 16/4/7.
 */
public class ContributorPresenter extends MvpBasePresenter<ContributorView> {

    private Subscriber<Contributor> contributorSub = new Subscriber<Contributor>() {

        @Override
        public void onStart() {
            ContributorView view = getView();
            if(view != null){
                view.onLoadContributorStart();
            }
        }

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Contributor topContributor) {
            ContributorView view = getView();
            if(view != null){
                view.onLoadContributorComplete(topContributor);
            }
        }
    };

    public void get(String owner,String repo){
        GitHubApi.getContributors(owner, repo)
                .take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<List<Contributor>, Contributor>() {

                    @Override
                    public Contributor call(List<Contributor> contributors) {
                        return contributors.get(0);
                    }
                })
                .subscribe(contributorSub);
    }

    public void change(){
        ContributorView view = getView();
        if(view != null){
            view.onChangeContributorName("zjutkz");
        }
    }
}
