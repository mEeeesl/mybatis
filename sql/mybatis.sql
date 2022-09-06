-- system user     - - - - workspace - mybatis - sql - 파일넣기
drop user mybatis cascade;
-- 왼쪽 스키마 mybatis 우클릭 접속해제 누르고 진행

-- 과제] mybatis/mybatis user를 만들어라.
create user mybatis identified by mybatis default tablespace users;
grant connect, resource to mybatis;
/*
-- 과제] 테이블 설계도를 보고, 테이블 3개를 만들어라.

-- mybatis user로 전환후 create 하거나 ( 귀찮음 )
-- system user 상태에서 mybatis.접두사 붙이면됨
drop table mybatis.users;
drop table mybatis.addresses;
drop table mybatis.posts;
drop user mybatis cascade; -- 전체삭제
-- 왼쪽 스키마 mybatis 우클릭 접속해제 누르고 진행

create table mybatis.users (
    user_id number(2) constraint users_userid_pk primary key,
    user_name varchar2(12),
    reg_date date);

create table mybatis.addresses (
    user_id number(2) constraint addr_userid_pk primary key
                    constraint addr_userid_fk references mybatis.users(user_id),
    address varchar2(30));

create table mybatis.posts (
    post_id number(3) constraint posts_postid_pk primary key,
    post_title varchar2(60),
    post_content varchar2(120),
    user_id number(2) constraint posts_userid_fk references mybatis.users(user_id));
    
desc dba_tables
select owner, table_name, tablespace_name
from dba_tables
where owner = 'MYBATIS';

*/
------------------------------------------
-- 테이블 먼저 만들고 제약조건을 차후에 추가해보기

create table mybatis.users(
    user_id number(2),
    user_name varchar2(12),
    reg_date date);
    
create table mybatis.addresses(
    user_id number(2),
    address varchar2(30));
    
create table mybatis.posts(
    post_id number(3),
    post_title varchar2(60),
    post_content varchar2(120),
    user_id number(2));
    
alter table mybatis.users
    add constraint user_userid_pk primary key(user_id);

alter table mybatis.addresses
    add constraint addr_userid_pk primary key(user_id);

alter table mybatis.posts
    add constraint post_postid_pk primary key(post_id);

alter table mybatis.addresses
    add constraint addr_userid_fk foreign key(user_id)
    references mybatis.users(user_id);

alter table mybatis.posts
    add constraint post_userid_fk foreign key(user_id)
    references mybatis.users(user_id);
    
-- insert 할때 부모테이블(users)부터 넣어야함

insert into mybatis.users
    values(1, 'john', to_date('2022-07-22', 'yyyy-mm-dd'));
insert into mybatis.users
    values(2, 'terry', to_date('2022-07-23', 'yyyy-mm-dd'));
    
insert into mybatis.addresses
    values(1, '서울시 마포구');
insert into mybatis.addresses
    values(2, '성남시 분당구');
    
insert into mybatis.posts
    values(101, '사랑', '너와 나의 연결고리' ,1);
insert into mybatis.posts
    values(102, '정의', '너와 나의 연대고리' ,1);
insert into mybatis.posts
    values(201, '김치', '네가 있어야 밥을 먹지.',2);
insert into mybatis.posts
    values(202, '비빔밥', '동학농민항쟁이 만든 음식이다.', 2);
insert into mybatis.posts
    values(203, '찹쌀떡', '네가 그리워.', 2);

commit;