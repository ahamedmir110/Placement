package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
const express = require('express');
const app = express()
app.use(express.json());
let books = [];
let nextId=1;
//post events
app.post("/api/events",(req,res)=>{
	const{id, title, venue, category, ticketPrice, seatsAvailable, isOnline}=req.body;
	const postevent = {"id": 1, "title": "DevFest Chennai", "venue": "Trade Centre", "category": "Tech", "ticketPrice": 499, "seatsAvailable": 250, "isOnline": false};
	events.push(postevent);
	res.status(201).json(postevent);
});
//get events
app.get("/api/events/:id",(req,res)=>{
	const id = parselnt(req.params.id);
	const event = events.find (b=>b.id===id);
	if(!event){
		return
		res.status(404).json({message:"event not found"});
	}
	res.json(event);
});
//put and patch events
app.put("/api/books/:id",(req,res)=>{
	const id = parselnt(req.params.id);
	const event = events.find(b=>b.id===id);
	if(!event){
		return
		res.status(404).json({message:"event not found"});
	}
	const{id, title, venue, category, ticketPrice, seatsAvailable, isOnline}=req.body;
	event.id = id;
	event.title = title;
	event.venue = venue;
	event.category = category;
	event.ticketPrice = ticketPrice;
	event.seatsAvailable = seatsAvailable;
	event.isOnline = isOnline;
	res.json(event)
});
//delete event
app.delete("/api/events/:id",(req,res)=>{
	const id = parselnt(req.params.id);
	const index = events.findIndex(b=>b.id===id);
	if(index===-1){
		return
		res.status(404).json({message:"event not found"});
	}
	events.slice(index,1);
	res.json({message:"Book deleted successfully"});
});
app.listen(8080,()=>{
	console.log("server is running on port 8080");
});

