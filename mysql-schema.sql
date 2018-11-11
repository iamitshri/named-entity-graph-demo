 
create table task(
	task_id int auto_increment primary key,
    task_name tinytext
);
create table aspects(
	aspect_id int auto_increment primary key,
	aspect_name tinytext,
	task_id int ,
    foreign key (task_id) references task(task_id) on delete cascade 
);

create table anchors(
	anchor_id int auto_increment primary key,
	anchor_name tinytext,
	aspect_id int ,
    foreign key (aspect_id) references aspects(aspect_id) on delete cascade 
);

insert into task(task_name) values('test1');

insert into aspects (aspect_name,task_id) values('aspect test',1);
insert into aspects (aspect_name,task_id) values('aspect test2',1);
 
insert into anchors (anchor_name, aspect_id) values('anchor test',1);
insert into anchors (anchor_name, aspect_id) values('anchor test2',1);

insert into anchors (anchor_name, aspect_id) values('anchor test3',3);
insert into anchors (anchor_name, aspect_id) values('anchor test4',3);


select * from task t join aspects aspects on t.task_id = aspects.task_id join anchors on anchors.aspect_id = aspects.aspect_id;