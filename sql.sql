
create table member(
kind number(1) constraint member_level_NN not null,
id varchar2(400) constraint member_id_PK primary key,
pw varchar2(400) constraint member_pw_NN not null,
name varchar2(400) constraint member_name_NN not null,
email varchar2(400) constraint member_email_U unique,
phone varchar2(400) constraint member_phone_U unique,
bid varchar2(400) constraint member_bid_FK references ban (bid)
)

create table point (
num number(8) constraint point_num_NN not null,
id varchar(400) constraint point_id_FK references member,
kor number(3) constraint point_kor_NN not null,
eng number(3) constraint point_eng_NN not null,
math number(3) constraint point_math_NN not null,
total number(3) constraint point_total_NN not null,
avg number(3) constraint point_avg_NN not null,
term number(1) constraint point_term_NN not null,
bid varchar2(400) constraint point_bid_FK references ban (bid)
)

create sequence point_seq
start with 1
increment by 1
nomaxvalue

create table ban(
bid varchar2(400) constraint ban_bid_PK primary key,
bnum number(2) constraint ban_bnum_NN not null,
tname varchar2(400) constraint ban_tname_NN not null
)

insert into member values (2,'stu3','oracle','c','c','3','c')

insert into POINT values (point_seq.nextval,'stu1',80,80,80,240,80,2,'a')
insert into POINT values (point_seq.nextval,'stu2',70,70,70,210,70,2,'b')
insert into POINT values (point_seq.nextval,'stu3',60,60,60,180,60,2,'c')


create table member(
kind number(1) not null,
id varchar2(400) constraint member_id_PK primary key,
pw varchar2(400) not null,
name varchar2(400) not null,
email varchar2(400) constraint member_email_U UNIQUE,
phone varchar2(400) constraint member_phone_U UNIQUE,
bid varchar2(400) constraint member_bid_FK references ban (bid)
)

insert into point values (point_seq.nextval,?,?,?,?,?,?,?,(select bid from member where id=?))
update point set kor=?, eng=?, math=?, total=?, avg=?, term=?, bid=? where id=?

update point set kor=60, eng=60, math=60, total=180, avg=60 where id='sys2' and term=2
update point set kor=60 where id='stu2' and term=2
