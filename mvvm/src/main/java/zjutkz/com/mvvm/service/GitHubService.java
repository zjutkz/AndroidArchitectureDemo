package zjutkz.com.mvvm.service;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import zjutkz.com.mvvm.viewmodel.Contributor;


/**
 * Created by kangzhe on 16/4/7.
 */
public interface GitHubService {
    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
}