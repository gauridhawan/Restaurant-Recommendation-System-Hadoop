create external table inspection_test1 
(serial_number string, 
restaurant_name string, 
location_name string, 
address string, 
city string, 
state string, 
inspection_grade string) 
row format delimited fields terminated by '\t' 
location '/user/gd1302/inspectionProject/inspectionTsvV4';

select * from inspection_test1;

select distinct(inspection_grade) from inspection_test1;

select inspection_grade, count(inspection_grade) from inspection_test1 group by inspection_grade;

create external table business2
(business_id string,
 name string, 
 address string,
 city string,
 state string,
 stars float,
 review_count int,
 categories string,
 hours string)
 row format delimited fields terminated by '\t'
 location '/user/gd1302/businessData3';

select * from business2;

select distinct(stars) from business2;

select inspection_grade, count(inspection_grade) from inspection_test1 group by inspection_grade;

select count(*) from inspection_test1 it JOIN business2 b ON it.restaurant_name = b.name AND it.address = b.address;

select count(*) from inspection_test1 it JOIN business2 b ON it.restaurant_name = b.name AND it.address = b.address GROUP BY b.stars;

select * from business2 b JOIN inspection_test1 t ON b.name = t.restaurant_name AND b.address = it.address GROUP BY t.inspection_grade;

select b.stars, COUNT(b.stars) from from business2 b JOIN inspection_test1 t ON b.name = t.restaurant_name AND b.address = it.address WHERE t.inspection_grade = 'A' GROUP BY b.stars;


select b.stars, COUNT(b.stars) from from business2 b JOIN inspection_test1 t ON b.name = t.restaurant_name AND b.address = it.address WHERE t.inspection_grade = 'B' GROUP BY b.stars;


select b.stars, COUNT(b.stars) from from business2 b JOIN inspection_test1 t ON b.name = t.restaurant_name AND b.address = it.address WHERE t.inspection_grade = 'C' GROUP BY b.stars;

