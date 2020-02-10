--create
create table message(
m_id int,
m_account int,
m_stake number,
m_time timestamp,
CONSTRAINT pk_message PRIMARY KEY (m_id)
)

create table notification(
n_id int,
n_account int, 
n_stake number,
n_time timestamp,
n_description varchar2(100),
CONSTRAINT pk_notification PRIMARY KEY (n_id)
)

CREATE SEQUENCE sq_message START WITH 1 INCREMENT BY 1
CREATE SEQUENCE sq_notification START WITH 1 INCREMENT BY 1


--select
select * from message
select * from notification

delete from message
delete from notification

drop table message
drop table notification

drop sequence message
drop sequence notification

--insert
insert into message(m_id, m_account, m_stake, m_time)
values (sq_messaege.nextval, 1, 1.1, CURRENT_TIMESTAMP)
