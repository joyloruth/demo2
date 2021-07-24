package com.joyloruth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



	@Service
	@Transactional
	public class JobService {
		
		
		@Autowired
		private JobRepository jobRepo;
		
		public List<Job> listAll() {
			return jobRepo.findAll();
		}
		
		public void save(Job job) {
			jobRepo.save(job);
		}
		
		public Job get(long jobid) {
			
			return jobRepo.findById(jobid).get();
		}
		
		public void delete(long jobid) {
			jobRepo.deleteById(jobid);
		}
		

}
