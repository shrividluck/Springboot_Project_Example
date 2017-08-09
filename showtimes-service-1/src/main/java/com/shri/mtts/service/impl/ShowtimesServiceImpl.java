/**
 * @author shrividluck
 *
 */
package com.shri.mtts.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shri.mtts.entity.Showtimes;
import com.shri.mtts.externalresource.TheaterServiceClient;
import com.shri.mtts.repository.ShowtimeRepository;
import com.shri.mtts.service.ShowtimesService;
import com.shri.mtts.service.exception.ErrorCode;
import com.shri.mtts.service.exception.InvalidFieldException;
import com.shri.mtts.service.exception.MTTSException;


@Service
public class ShowtimesServiceImpl implements ShowtimesService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ShowtimeRepository shRepository;

	@Autowired
	private TheaterServiceClient theaterServiceClient;


	public Iterable<Showtimes> getAllMovieShowtimes(String theater) {
		// TODO Auto-generated method stub
		return null;
	}


	public Iterable<Showtimes> getAllTheaterShowtimes(String movie) {
		// TODO Auto-generated method stub
		return null;
	}


	public void updateShowtime(String movie, String theater, String time) {
		// TODO Auto-generated method stub
		
	}		
}


