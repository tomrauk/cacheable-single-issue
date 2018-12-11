package cacheable.single.issue


import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("https://github.com")
interface TagClient {

  @Get("/micronaut-projects/micronaut-core/releases/tag/v{version}")
  Single<String> getTag(String version)
}
