This project exposes the [Wikidata API](https://doc.wikimedia.org/Wikibase/master/js/rest-api/) as a Kotlin library.

# Wikidata API

For testing, get yourself an API token:

1. Go to https://meta.wikimedia.org/wiki/Special:OAuthConsumerRegistration/propose/oauth2 to request yourself an API token
2. Mark the client as confidential
3. Mark it as consumer use for yourself only and the token is auto-accepted for 30 days. 
4. Request specific permissions, but only the basic rights is enough.
5. Submit the proposal, get Client application key, Client application secret, and Access token

Now you may try the API with this library, or manually:

1. Go to https://doc.wikimedia.org/Wikibase/master/js/rest-api/ to find examples of all the API calls
2. Note that the page has an invalid "example" server configured to it 
   -- use https://www.wikidata.org/w/rest.php/wikibase/v0 instead, like this:

```shell
curl -X 'GET' \
   'https://www.wikidata.org/w/rest.php/wikibase/v0/entities/items/Q42' \
   -H 'accept: application/json' \
   -H 'Authorization: Bearer YOUR_ACCESS_TOKEN_GOES_HERE'
```

# Using this library

If you work with Maven, add a new repository into your `~/.m2/settings.xml` file:

```xml

<repository>
   <id>github</id>
   <url>https://maven.pkg.github.com/ZeroOne3010/yetanotherwikidataapi</url>
   <!--snapshots>
     <enabled>true</enabled>
   </snapshots-->
</repository>
```

Also add [username and access token for GitHub Packages](https://docs.github.com/en/packages/learn-github-packages/about-permissions-for-github-packages):

```xml

<servers>
   <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <password>YOUR_GITHUB_TOKEN_WITH_READ_PACKAGES_PRIVILEGE</password>
   </server>
</servers>
```

Then, in your project's pom.xml, include this artifact:

```xml

<dependency>
   <groupId>io.github.zeroone3010</groupId>
   <artifactId>yetanotherwikidataapi</artifactId>
   <version>0.0.1</version>
</dependency>
```

Now, a minimal code example would look like this:

```java
import io.github.zeroone3010.wikidata.Item;
import io.github.zeroone3010.wikidata.Wikidata;

public class Main {
   public static void main(String[] args) {
      Wikidata wikidata = new Wikidata(args[0]);
      String itemId = "Q1085";
      Item item = wikidata.getItem(itemId);
      System.out.println(itemId + " is " + item.getLabels().get("en"));
   }
}
```

And it would print out "`Q1085 is Prague`". 
