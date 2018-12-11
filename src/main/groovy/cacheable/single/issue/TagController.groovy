package cacheable.single.issue

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single

import javax.inject.Inject

@Controller("/tags")
class TagController {

  @Inject
  TagClient tagClient

  @Inject
  CacheTagClient cacheTagClient

  @Get("/version/{version}")
  Single<String> getTag(String version) {
    tagClient.getTag(version)
  }

  @Get("/version/cache/{version}")
  Single<String> getTagCached(String version) {
    cacheTagClient.getTag(version)
  }
}
