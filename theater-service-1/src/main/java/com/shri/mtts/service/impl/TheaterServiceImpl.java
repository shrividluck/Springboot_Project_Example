
package com.shri.mtts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shri.mtts.entity.Theater;
import com.shri.mtts.entity.impl.TheaterImpl;
import com.shri.mtts.service.TheaterService;

	
@Service
public class TheaterServiceImpl implements TheaterService {

	@Override
	public void addMovieToTheater(String movie, Theater th) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public Theater addTheater(String theaterName) {
		// TODO Auto-generated method stub
		return new TheaterImpl(theaterName);
	}

	@Override
	public Theater addTheater(Theater theater) {
		// TODO Auto-generated method stub
		return theater;
	}

	@Override
	public List<String> getMoviesInTheater(Theater theater) {
		// TODO Auto-generated method stub
		List<String> MP = new ArrayList<String>();
		if(theater.getTheaterName().equals("theater-10")) {
			MP.add("T1");
			MP.add("T2");
			MP.add("SpiderMan HomeComing");
		} else {
			MP.add("NoMovie");
		}
		//return theater.getMoviesPlaying();
		return MP;
	}

	@Override
	public List<String> getUpComingMoviesInTheater(Theater theater) {
		// TODO Auto-generated method stub
		List<String> MP = new ArrayList<String>();
		if(theater.getTheaterName().equals("theater-10")) {
			MP.add("IronMan");
			MP.add("KingKong");
			MP.add("Dracula");
		} else {
			MP.add("NoMovie");
		}
		//return theater.getUpcomingMovies();
		return MP;
	}

	@Override
	public List<Theater> getTheaterList(String movieName) {
		// TODO Auto-generated method stub
		if("t1".equals(movieName)) {
		  List<Theater> list = new ArrayList<>();
		  list.add(new TheaterImpl("theater-10"));
		  list.add(new TheaterImpl("theater-12"));
		  return list;
		}
		return null;
	}

	@Override
	public List<Theater> getTheaterList(long pinCode) {
		// TODO Auto-generated method stub
		List<Theater> list = new ArrayList<>();
		if( pinCode == 1234) {
			list.add(new TheaterImpl("theater-10"));
			list.add(new TheaterImpl("theater-11"));
			list.add(new TheaterImpl("theater-12"));
			list.add(new TheaterImpl("theater-13"));
			return list;
		} 
		return null;
	}

	@Override
	public List<Theater> getTheaterList(String mName, long pinCode) {
		// TODO Auto-generated method stub
		if("t1".equals(mName) && pinCode == 1234) {
			List<Theater> list = new ArrayList<>();
			list.add(new TheaterImpl("theater-10"));
			list.add(new TheaterImpl("theater-12"));
			return list;
		}
		return null;
	}

/*	@Override
	public Theater getTheaterName(long id) {
		// TODO Auto-generated method stub
		return new TheaterImpl();
	}

	@Override
	public Theater getTheaterName(String tName) {
		// TODO Auto-generated method stub
		return new TheaterImpl(tName);
	}

	*/

}