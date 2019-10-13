# Bill Dwyer's Resume App

## Alpha

- ~~App icon~~
- ~~Create JSON doc of resume~~
- ~~Load JSON doc~~
- Parse JSON
- Create UI for resume from JSON doc
  - Use architectural components/jetpack
- Post to Play Store

## Beta

- Integrate share sheet for various social links (LinkedIn/Github/email?)
- Firebase
  - Crashlytics
  - Performance
  - Test Lab

## 1.0 Release

- CI Builds
  - Lint check
  - Run Test
- Versioning
- Animations


## Backlog

- Create playground section I can use as a container for testing now new Android features
  - Create public/private sections (authenticate with Firebase Auth) so I can show off features, but also test some that are only intended for me
- Maybe some firebase integration?
- Push notifications via firebase just for fun
- Check for updates to JSON resume and load them from github repo if it is newer than locally cached version
  - Add splashscreen where this network call can be used
  - Create test I can run before I push JSON resume updates so I can be confident my update won't break currently installed apps
- Setup integrations with twillio web hooks so people can chat with me through the app via text?
  - Doublecheck billing/rate limiting thresholds on server/client so I don't get a huge bill through misuse!
  - On second thought, checkout firebase for this
- Firebase 
  - ML Kit for sure
  - Use Authentication before people can contact me.
- Create "nerd view" with a view of the underlying JSON
- Export as PDF