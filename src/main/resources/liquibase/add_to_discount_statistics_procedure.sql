create procedure `spring_pr`.`add_to_discount_statistics` (user_id int, discount_type varchar(100))
	begin
		declare rows_inserted_num int;
        set rows_inserted_num = (select count(*) from spring_pr.discount_statistics ds
									where ds.user_id = user_id and ds.discount_type = discount_type);
		if rows_inserted_num = 0
			then insert into spring_pr.discount_statistics(user_id, discount_type, count)
				values(user_id, discount_type, 1);
		else update spring_pr.discount_statistics ds set count = count + 1
			where ds.user_id = user_id and ds.discount_type = discount_type;
		end if;
	end;