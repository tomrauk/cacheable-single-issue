package cacheable.single.issue

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class TagSpec extends Specification {

  @Shared
  @AutoCleanup
  EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

  @Shared
  @AutoCleanup
  HttpClient client = HttpClient.create(embeddedServer.URL)

  void "able to call tags version"() {
    expect:
    client.toBlocking().exchange(HttpRequest.GET('/tags/version/1.0.0')).status() == HttpStatus.OK
  }

  void "able to call tags version cached"() {
    expect:
    client.toBlocking().exchange(HttpRequest.GET('/tags/version/cache/1.0.0')).status() == HttpStatus.OK
  }
}
