

DROP DATABASE IF EXISTS db;
CREATE DATABASE db;
# CREATE DATABASE shop;

DROP TABLE IF EXISTS db.user;
CREATE TABLE db.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK', 
  username VARCHAR(255) NOT NULL UNIQUE
  COMMENT 'username',
  password VARCHAR(255) NOT NULL
  COMMENT 'password',
  avatar    varchar(255) comment 'avatar',
  addressId INT UNIQUE COMMENT 'addressId id FK'
)
  COMMENT 'user table';


# SELECT count(*) FROM db.user;-- 数据的总条数642 8632
SELECT * FROM db.user;


# 日期格式  2018.01.02  DECIMAL(8, 2)  表示两位小数 bigInt对应长整型 UNIQUE 数据唯一
DROP TABLE IF EXISTS db.book;
CREATE TABLE db.book (
  id     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  title   VARCHAR(255)  NOT NULL
  COMMENT 'title NN',
  price   DECIMAL(8, 2) NOT NULL
  COMMENT 'price NN',
  amount  INT           NOT NULL
  COMMENT 'amount NN',
  pubTime DATE          NOT NULL
  COMMENT 'publish time NN',
  userId INT COMMENT 'user id FK'
)
  COMMENT 'book table';



SELECT *
FROM db.book;

DROP TABLE IF EXISTS db.address;
CREATE TABLE db.address (
  id  INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  detail   VARCHAR(255)  NOT NULL
  COMMENT 'detail NN',
  userId INT UNIQUE COMMENT 'user id FK'
)
  COMMENT 'book address';

SELECT *
FROM db.address;


# 学生表
DROP TABLE IF EXISTS db.student;
CREATE TABLE db.student (
  id  INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  name   VARCHAR(255)  NOT NULL
  COMMENT '姓名'

)
  COMMENT 'book student';

SELECT *
FROM db.student;

# 课程表
DROP TABLE IF EXISTS db.course;
CREATE TABLE db.course (
  id  INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  title   VARCHAR(255)  NOT NULL
  COMMENT '课程名'

)
  COMMENT 'book course';

SELECT *
FROM db.course;

# 针对学生和课程相互关联的表

DROP TABLE IF EXISTS db.student_course;
CREATE TABLE db.student_course (
  id  INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  studentId int comment 'student id FK',
  courseId  int comment 'course id Fk'
)
  comment 'student course table';

SELECT *
FROM db.student_course;

# 生成数据库的外键  图书表和用户表对应
ALTER  TABLE  db.book
  ADD CONSTRAINT
  book_fk_userId
FOREIGN KEY (userId)
REFERENCES db.user(id);

# 生成数据库的外键  地址和用户对应
ALTER  TABLE  db.address
  ADD CONSTRAINT
  address_fk_userId
FOREIGN KEY (userId)
REFERENCES db.user(id);


# 生成数据库的外键  用户和地址对应
ALTER  TABLE  db.user
  ADD CONSTRAINT
  user_fk_addressId
FOREIGN KEY (addressId)
REFERENCES db.address(id);


# 生成数据库 学生课程表和学生的外键
alter table db.student_course
  add constraint
  student_course_fk_studentId
foreign key (studentId)
references db.student (id);

# 生成数据库 学生课程表和学生的外键
alter table db.student_course
  add constraint
  student_course_fk_courseId
foreign key (courseId)
references db.course (id);


# 向三个表插入数据
insert into db.student value (null, 'S1');
insert into db.student value (null, 'S2');
insert into db.student value (null, 'S3');

insert into db.course value (null, 'C1');
insert into db.course value (null, 'C2');
insert into db.course value (null, 'C3');

insert into db.student_course value (null, 1, 1);
insert into db.student_course value (null, 1, 2);
insert into db.student_course value (null, 2, 1);
insert into db.student_course value (null, 2, 2);


# 联合查询
SELECT u.username,b.*
FROM db.user AS u  LEFT OUTER JOIN  db.book AS b ON u.id=b.userId WHERE u.id=3;

SELECT
  u.username,
  b.title, b.price, b.amount, b.pubTime
FROM db.user AS u INNER JOIN db.book AS b
    ON u.id = b.userId
WHERE u.id = 1;

# 三表联合查询  查询条件 n-1  student_course要有模型类
SELECT
  s.name,
  c.title
from db.student as s inner join db.course as c
  inner join db.student_course sc
    on c.id = sc.courseId and s.id = sc.studentId
where s.id = 2;



/*
SELECT '123';
# md5加密
SELECT md5('123');*/

/*
ALTER TABLE db.book
  AUTO_INCREMENT 2147483647;*/ -- int max value 让id从整型的最大值开始
