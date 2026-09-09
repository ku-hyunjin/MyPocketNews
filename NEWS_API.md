# News API

## Selected source

- API: MediaWiki Action API
- Content: English Wikipedia `Portal:Current events` daily pages
- Base URL: `https://en.wikipedia.org/w/api.php`
- Account registration: Not required for read-only requests
- API key: Not required for read-only requests
- Cost: Free
- API source license: GPL-2.0-or-later
- Current events text license: CC BY-SA 4.0

MediaWiki was selected because its source license and the reuse terms for the
current events text are published clearly. This project will use the API only
to read the community-written current events summaries and their source links.

## Request

The page name changes with the requested date.

```text
GET https://en.wikipedia.org/w/api.php
    ?action=parse
    &page=Portal:Current events/{yyyy MMMM d}
    &prop=wikitext|links
    &format=json
    &formatversion=2
```

Example for August 16, 2026:

```text
https://en.wikipedia.org/w/api.php?action=parse&page=Portal%3ACurrent%20events%2F2026%20August%2016&prop=wikitext%7Clinks&format=json&formatversion=2
```

Every request must include a descriptive user agent:

```text
User-Agent: MyPocketNews/1.0 (https://github.com/ku-hyunjin/MyPocketNews)
```

## Verified response

The example request was tested on August 16, 2026 and returned HTTP 200 with a
real current events response. The response had the following structure:

```json
{
  "parse": {
    "title": "Portal:Current events/2026 August 16",
    "pageid": 83976994,
    "wikitext": "...",
    "links": [
      {
        "ns": 0,
        "title": "...",
        "exists": true
      }
    ]
  }
}
```

- `parse.title`: Title of the requested daily page
- `parse.pageid`: Wikipedia page identifier
- `parse.wikitext`: Current events categories, summaries, and source links
- `parse.links`: Wikipedia pages referenced by the daily page

The number and contents of events can change as Wikipedia contributors update
the page.

## Content mapping plan

- News title: Main topic link or a short title derived from the event summary
- News description: Current event summary text
- Source name: Label of the external source link
- Article URL: External source link included with the summary
- Image URL: Not taken from Wikipedia or the external publisher

The API returns wiki markup instead of ready-made news objects. A later feature
will parse each event and map it to the app's `Article` model.

## License and safety rules

- Display an attribution link to the exact Wikipedia daily page used as the
  source.
- Display `Current events text from Wikipedia contributors, CC BY-SA 4.0` and
  link to the CC BY-SA 4.0 license.
- Clearly mark translated or otherwise modified summaries and keep those
  adaptations under CC BY-SA 4.0.
- Keep the original external publisher link, but do not copy or store the
  publisher's article body.
- Do not automatically use images from Wikipedia or external news publishers.
  Continue using only separately verified CC0 images recorded in
  `IMAGE_LICENSES.md`.
- Do not use Wikimedia or publisher logos and do not imply endorsement or an
  official partnership.
- Cache responses responsibly, avoid unnecessary repeated requests, and follow
  any server rate-limit or retry instructions.

## Official references

- MediaWiki Action API: https://www.mediawiki.org/wiki/API:Main_page
- MediaWiki license: https://www.mediawiki.org/wiki/Copyright
- Wikipedia Current Events: https://en.wikipedia.org/wiki/Portal:Current_events
- Wikimedia Terms of Use: https://foundation.wikimedia.org/wiki/Policy:Terms_of_Use
- Wikimedia API Usage Guidelines: https://foundation.wikimedia.org/wiki/Policy:Wikimedia_Foundation_API_Usage_Guidelines
- Wikimedia User-Agent Policy: https://foundation.wikimedia.org/wiki/Policy:Wikimedia_Foundation_User-Agent_Policy
- CC BY-SA 4.0: https://creativecommons.org/licenses/by-sa/4.0/
