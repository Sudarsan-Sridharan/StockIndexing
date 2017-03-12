import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { Button, Col, Jumbotron, Container, Row } from 'react-bootstrap';

import classnames from 'classnames';
import superagent from 'superagent';

export default class App extends Component {
    constructor(){
        super();
        console.log('superagent', superagent);
        let response = superagent
            .post('/api/hello')
            .send({name : 'Arpit Goyal'})
            .set('Accept', 'application/json')
            .end((err, res) => console.log(res.text));
    }

  render() {
    return (
    	<div className="container-fluid">
    	   		
    		<div className={classnames('page-header', 'jumbotron')}>
    			<h1>Hello, Twitter Bootstrap!</h1>		
    		</div>
    		<div className="jumbotron">
    			<p>Some text!!</p>
    			<p>
    				<a href="#" className={classnames('btn', 'btn-default', 'btn-lg')}>
    				More Info</a>

    				<button type="button" value="Info" className={classnames('btn', 'btn-success', 'btn-lg')}>
    					Info
    				</button>
    			</p>
    			<Button >React Bootstrap Button</Button>

    		</div>

    		<Jumbotron>
    			<h1>Hello, World!</h1>
    			<p>This is a simple hero unit, a simple jumbotron style component</p>
    			<p><Button bsStyle="danger">Learn More</Button></p>
    		</Jumbotron>

    		<Row>
    			<Col xs={3} md={9} style={{backgroundColor: 'yellow'}}>
    				<h1>Column 1</h1>
    			</Col>
    			<Col xs={9} md={3} style={{backgroundColor: 'red'}}>
    				<h1>Column 2</h1>
    			</Col>
    		</Row>

    		<Row>
    			<Col xs={6}>
    				<button className="btn btn-success btn-lg">
    					Click Me!
    				</button>
    			</Col>
    			<Col xs={6}>
    				<Button bsStyle="danger" bsSize="lg">Click Me!</Button>
    			</Col>
    		</Row>

    		<Row>
    			<Col xs={12}>
    				<div className="btn-group btn-group-lg">
    					<button className="btn btn-primary btn-sm">Small</button>
    					<button className="btn btn-danger btn-md">Medium</button>
    					<button className="btn btn-success btn-lg">Large</button>    					
    				</div>
    			</Col>    			
    		</Row>
    	
      </div>
    );
  }
}
