# Goal

This project aims to help [Elasticsearch](https://www.elastic.co/)(a.k.a, ES) developers, **from their local IDEs**, to

- run ES source code
- create and debug custom plugins supporting
  - RESTful APIs
  - Java APIs




# Structure

From reading the source code, I felt that [ES's source code](https://github.com/elastic/elasticsearch) has no backward-compatible guarantee on interfaces, and hence I made the first-level directories to serve different versions, with the version explicitly shown in the directory names.