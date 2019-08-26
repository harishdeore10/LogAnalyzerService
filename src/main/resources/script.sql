create table EVENT (
   id VARCHAR(50) NOT NULL,
   host VARCHAR(20) default NULL,
   type  VARCHAR(20) default NULL,
   duration     INT  default NULL,
   alert BOOLEAN DEFAULT FALSE NOT NULL,
   PRIMARY KEY (id)
);