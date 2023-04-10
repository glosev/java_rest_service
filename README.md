# java_rest_service
Java restService project that implements methods to read and write employee entries into some main log.

# API


| Method | URI            | Description                                                                                            | Parameters                               |
|--------|----------------|--------------------------------------------------------------------------------------------------------|------------------------------------------|
| POST   | /employee/add  | Creates new employee entry                                                                             | String name, String surname, String role |
| GET    | /employee/{id} | Returns specified employee entry as JSON structure if any and returns exception instead                | UUID id                                  |
| GET    | /employee/list | Returns list of all employee entries as JSON structure                                                 | none                                     |
| Patch  | /employee/{id} | Changes passed parameters if any and returns employee entry. Returns exception if not entry was found  | UUID id                                  |
| Delete | /employee/{id} | Deletes specified employee entry if any and returns exception instead                                  | UUID id                                  |



