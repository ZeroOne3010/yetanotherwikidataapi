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
```
curl -X 'GET' \
   'https://www.wikidata.org/w/rest.php/wikibase/v0/entities/items/Q42' \
   -H 'accept: application/json' \
   -H 'Authorization: Bearer YOUR_ACCESS_TOKEN_GOES_HERE'
```
