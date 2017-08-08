
package com.shri.mtts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shri.mtts.service.exception.ErrorCode;
import com.shri.mtts.service.exception.MTTSException;
import com.shri.mtts.service.exception.InvalidFieldException;
import com.shri.mtts.entity.Theater;
import com.shri.mtts.entity.impl.TheaterImpl;
import com.shri.mtts.repository.TheaterRepository;
import com.shri.mtts.service.TheaterService;

	
@Service
public class TheaterServiceImpl implements TheaterService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterRepository tRepository;
	
	@Override
	public Theater getTheaterName(long id) {
		Theater tfound = tRepository.findOne(id);
		if(tfound==null){
			throw new MTTSException(ErrorCode.NOT_FOUND, "Theater not found");
		}
		return tfound;
	}
	
	@Override
	public void addMovieToTheater(String movie, Theater th) {
		return;
	}

	@Override
	public Theater addTheater(String theaterName) {
		return new TheaterImpl(theaterName);
	}

	@Override
	public Theater addTheater(Theater theater) {
		if( theater.getTheaterName() == null){
			throw new InvalidFieldException("Name is required");
		}
		TheaterImpl impl = tRepository.findByTheaterName(theater.getTheaterName());
		
		if(impl != null) {
			return impl;
		}
	    impl = (TheaterImpl) theater;
		return tRepository.save(impl);
	}


	@Override
	public List<String> getUpComingMoviesInTheater(String theaterName) {
		if(StringUtils.isEmpty(theaterName)) {
			throw new MTTSException(ErrorCode.MISSING_DATA, "theaterName is required");
		}
		
		Iterable<TheaterImpl> tList = tRepository.findByTheaterNameContaining(theaterName);
		List<String> MP = new ArrayList<String>();
		for(Theater t: tList) {
			if(t.getTheaterName().equals(theaterName)) {
				MP.addAll(t.getUpcomingMovies());
			}
		}		
			
		return MP;
	}
	
	@Override
	public List<String> getMoviesInTheater(String theaterName) {
		if(StringUtils.isEmpty(theaterName)) {
			throw new MTTSException(ErrorCode.MISSING_DATA, "theaterName is required");
		}
		
		Iterable<TheaterImpl> tList = tRepository.findByTheaterNameContaining(theaterName);
		List<String> MP = new ArrayList<String>();
		for(Theater t: tList) {
			if(t.getTheaterName().equals(theaterName)) {
				MP.addAll(t.getMoviesPlaying());
			}
		}		
			
		return MP;
		
	}

	@Override
	public Iterable<TheaterImpl> getTheaterList(String movieName) {
		/*
		if("t1".equals(movieName)) {
		  List<Theater> list = new ArrayList<>();
		  list.add(new TheaterImpl("theater-10"));
		  list.add(new TheaterImpl("theater-12"));
		  return list;
		}
		return null;*/
		
		if(StringUtils.isEmpty(movieName)) {
			throw new MTTSException(ErrorCode.MISSING_DATA,"movie name required");
		}
		return tRepository.findByMoviesPlayingContaining(movieName);
			
	}

	@Override
	public Iterable<TheaterImpl> getTheaterList(int pincode) {
		
		/*List<Theater> list = new ArrayList<>();
		if( pincode == 1234) {
			list.add(new TheaterImpl("theater-10"));
			list.add(new TheaterImpl("theater-11"));
			list.add(new TheaterImpl("theater-12"));
			list.add(new TheaterImpl("theater-13"));
			return list;
		} 
		return null;*/
		if(pincode == 0) {
			throw new MTTSException(ErrorCode.MISSING_DATA,"pin code required");
		}
		return tRepository.findByPincode(pincode);
	}

	@Override
	public Iterable<TheaterImpl> getTheaterList(String mName, int pincode) {
		
		/*if("t1".equals(mName) && pincode == 1234) {
			List<Theater> list = new ArrayList<>();
			list.add(new TheaterImpl("theater-10"));
			list.add(new TheaterImpl("theater-12"));
			return list;
		}
		return null;*/
		if(StringUtils.isEmpty(mName) && (pincode == 0)){
			throw new MTTSException(ErrorCode.MISSING_DATA,"Atleast 1 required");
		}
		if(!StringUtils.isEmpty(mName) && (pincode == 0)){
			return tRepository.findByMoviesPlayingContaining(mName);
		}
		if(StringUtils.isEmpty(mName) && !(pincode == 0)){
			return tRepository.findByPincode(pincode);
		}		
		
		return tRepository.findByPincodeAndMoviesPlayingContaining(pincode, mName);		
		
	}

	
	@Override
	public Theater getTheaterName(String tName) {
		
		if(StringUtils.isEmpty(tName)) {
			throw new MTTSException(ErrorCode.MISSING_DATA,"theater name required");
		}
		return tRepository.findByTheaterName(tName);
	}
	
	@Override
	public Iterable<TheaterImpl> getTheaterListByName(String tName) {
		
		if(StringUtils.isEmpty(tName)) {
			throw new MTTSException(ErrorCode.MISSING_DATA,"theater name required");
		}
		return tRepository.findByTheaterNameContaining(tName);
	}

}