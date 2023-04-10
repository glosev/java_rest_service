# java_rest_service
Java restService project that implements methods to read and write employee entries into some main log.

# API


| Method | URI                     | Description                                                                                           | Parameters                               |
|--------|-------------------------|-------------------------------------------------------------------------------------------------------|------------------------------------------|
| POST   | /employees              | Creates new employee entry                                                                            | String name, String surname, String role |
| GET    | /employees              | Returns list of all employee entries as JSON structure                                                | none                                     |
| GET    | /employees/{identifier} | Returns specified employee entry as JSON structure if any and returns exception instead               | UUID uuid/Integer id                     |
| PATCH  | /employees/{identifier} | Changes passed parameters if any and returns employee entry. Returns exception if not entry was found | UUID uuid/Integer id                     |
| DELETE | /employees/{identifier} | Deletes specified employee entry if any and returns exception instead                                 | UUID uuid/Integer id                     |
| DELETE | /employees              | Deletes all employee entries                                                                          | none                                     |



