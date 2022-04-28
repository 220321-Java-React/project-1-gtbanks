------------project1

create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_amount int,
	reimb_submitted timestamp,
	user_id_fk int references ers_user (user_id),
	reimb_status_id_fk int references reimbursement_status (reimb_status_id),
	reimb_type_id_fk int references reimbursement_type (reimb_type_id)
);
----Workiking ers_reimbursement
create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_type text not null,
	reimb_amount int not null,
	reimb_author_id int,
	reimb_resolver_id int,
	reimb_submitted timestamp not null,
	user_id_fk int references ers_user (user_id),
	reimb_status_id_fk int references reimbursement_status (reimb_status_id),
	reimb_type_id_fk int references reimbursement_type (reimb_type_id)	
);
create table ers_reimbursements(
	reimb_id serial primary key,
	reimb_type text not null,
	reimb_amount int not null,
	reimb_submitted timestamp not null,
	reimb_author_id_fk int references ers_user (user_id),
	reimb_status_id_fk int references reimbursement_status (reimb_status_id),
	reimb_type_id_fk int references reimbursement_type (reimb_type_id)	
);


update ers_user
set user = 'America/California';

set to_timestamp() 

drop table ers_reimbursement; 
	
insert into ers_reimbursement(reimb_id, reimb_amount, reimb_submitted)
values (default, 300, default),
       (default, 175, default),
       (default, 894, default),
       (default, 320, default),
       (default, 550, default);
--------working
insert into ers_reimbursement(reimb_id, reimb_amount, reimb_submitted)
values (300),
       (175),
       (894),
       (324),
       (550);
alter ers_reimbursement 
	set reimb_submitted  = '2'
	where project_name = 'Vacations';
      
create table ers_users(
	user_id serial primary key,
	username text(5) unique not null,
	"password" text(5) unique not null,
	f_name text(10) not null,
	l_name text(10) not null,
	email text(10) not null,
	user_role_id_fk int references user_role (user_role_id) 
);
--------working ers users
create table ers_user(
	user_id serial primary key,
	username text unique not null,
	"password" text unique not null,
	f_name text not null,
	l_name text not null,
	email text not null,
	user_role_id_fk int references user_role (user_role_id) 
);

	  insert into ers_user( user_id, username, "password", f_name, l_name, email, user_role_id_fk)
values (default, 'sbriggs', 'sheri', 'Sherri', 'Briggs', 'sbriggs@rev.net', default);
	   (default, 'kbanks', 'ken', 'Ken', 'Banks', 'kbanx@rev.net', default),
	   (default, 'elamb', 'eric', 'Eric', 'Lamb', 'elamb@rev.net', default),
	   (default, 'ewhite', 'eryka', 'Eryka', 'White', 'ewhite@rev.net', default),
	   (default, 'devans','don', 'Don', 'Evans', 'devans@rev.net', default); 
alter table if exists ers_users
rename to ers_user;

create table status(
	reimb_status_id serial primary key,
	reimb_status text
);

insert into reimbursement_status (reimb_status_id, reimb_status)
values (default, 'Approved'),
	   (default, 'Pending'),
	   (default, 'Denied');

create table reimbursement_type(
	reimb_type_id serial primary key,
	reimb_type text
);

insert into reimbursement_type (reimb_type_id, reimb_type)
values (default, 'Travel'),
	   (default, 'Education'),
	   (default, 'Medical'),
	   (default, 'Other');
	   
	
create table user_role(
	user_role_id serial primary key,
	user_role text 
);

insert into user_role (user_role_id, user_role)
values (default, 'Manager'),
	   (default, 'IT'),
	   (default, 'Executive Assistant'),
	   (default, 'Driver'),
	   (default, 'Accountant');
	   