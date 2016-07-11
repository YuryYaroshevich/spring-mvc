package com.yra.springpr.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.yra.springpr.model.Event;
import com.yra.springpr.model.EventTimetable;
import com.yra.springpr.service.AuditoriumService;


public class TimetableDaoSpringJdbcImpl implements TimetableDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private AuditoriumService auditoriumService;

    public TimetableDaoSpringJdbcImpl(NamedParameterJdbcTemplate jdbcTemplate, AuditoriumService auditoriumService) {
        this.jdbcTemplate = jdbcTemplate;
        this.auditoriumService = auditoriumService;
    }

    @Override
    public List<EventTimetable> getEventTimetables(Event event) {
        return jdbcTemplate.getJdbcOperations()
                .query("select timetable_id, event_date, auditorium_id from timetable where event_id = ?",
                        (ResultSet rs, int i) -> {
                            return new EventTimetable(rs.getInt("timetable_id"), event,
                                    new Date(rs.getTimestamp("event_date").getTime()), 
                                    auditoriumService.getAuditoriumById(rs.getInt("auditorium_id")));
                        }, event.getId());
    }

	@Override
	public void assignAuditorium(long timetableId, int auditoriumId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("timetable_id", timetableId);
		params.addValue("auditorium_id", auditoriumId);
		jdbcTemplate.update("update timetable set auditorium_id = :auditorium_id where timetable_id = :timetable_id",
		       params);
	}
}
