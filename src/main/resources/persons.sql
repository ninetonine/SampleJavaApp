-- mysql --host 739300c07f6d8d87438fc83dde5794033ec19968.rackspaceclouddb.com --user itari --password=test sample_app < persons.sql
CREATE TABLE persons ( 
     id INT,
     firstName VARCHAR(100),
     lastName VARCHAR(100)
)


-- mysql --host 127.0.0.1 --user itari --password='change me' sample_app < persons.sql