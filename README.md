# java_rest_service
Java restService project that implements methods to read and write employee entries into some main log.

# API


| Method | URI             | Description                                                                                            | Parameters                               |
|--------|-----------------|--------------------------------------------------------------------------------------------------------|------------------------------------------|
| POST   | /employees      | Creates new employee entry                                                                             | String name, String surname, String role |
| GET    | /employees      | Returns list of all employee entries as JSON structure                                                 | none                                     |
| GET    | /employees/{id} | Returns specified employee entry as JSON structure if any and returns exception instead                | UUID id                                  |
| Patch  | /employees/{id} | Changes passed parameters if any and returns employee entry. Returns exception if not entry was found  | UUID id                                  |
| Delete | /employees/{id} | Deletes specified employee entry if any and returns exception instead                                  | UUID id                                  |



