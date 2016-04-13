package zjutkz.com.mvp.api;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import zjutkz.com.mvp.model.Contributor;
import zjutkz.com.mvp.service.GitHubService;

/**
 * Created by kangzhe on 16/4/7.
 */
public class GitHubApi {


    public static Observable<List<Contributor>> getContributors(String owner,String repo){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        return service.repoContributors(owner,repo);
    }
}
