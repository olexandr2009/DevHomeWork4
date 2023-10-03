select concat('YOUNGEST','') "TYPE", worker_name ,birthday  from workers
where birthday = (select max(birthday) from workers);

select concat('OLDEST','') "TYPE", worker_name ,birthday  from workers
where birthday = (select min(birthday) from workers);