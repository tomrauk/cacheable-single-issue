package cacheable.single.issue

import io.micronaut.cache.annotation.Cacheable
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("https://github.com")
@Cacheable("tags")
interface CacheTagClient {

  @Get("/micronaut-projects/micronaut-core/releases/tag/v{version}")
  Single<String> getTag(String version)
}
