# --- !Ups
CREATE SEQUENCE seq_visitor_id;
CREATE TABLE visitor (
    id INT NOT NULL DEFAULT NEXTVAL('seq_visitor_id'),
    name VARCHAR(255),
    seen TIMESTAMP AS CURRENT_TIMESTAMP
);
 
# --- !Downs
DROP TABLE visitor;
DROP SEQUENCE seq_visitor_id;
