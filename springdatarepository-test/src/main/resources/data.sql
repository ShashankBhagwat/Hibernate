insert into Course values (10001,'JPA');
insert into Course values (10002,'Java');
insert into Course values (10003,'Python');

insert into Passport values (40001,'SMHPB9763S');
insert into Passport values (40002,'MMHPB9763M');
insert into Passport values (40003,'KMHPB9762K');

insert into Student values (20001,'Shashank',40001);
insert into Student values (20002,'Manasa',40002);
insert into Student values (20003,'keerthi',40003);

insert into Rating(id,rating,description,course_id) values (50001,5,'Super',10001);
insert into Rating(id,rating,description,course_id) values (50002,4,'Awesome',10001);
insert into Rating(id,rating,description,course_id) values (50003,3,'Moderate',10003);

insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20001,10001);
insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20001,10002);
insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20002,10001);
insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20002,10002);
insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20003,10001);

/*
insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20003,10003);
*/
/*
select * from student_course ,student, course
where
student_course.student_id =student.id
AND
student_course.course_id = course.id;
*/