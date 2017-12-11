package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.pentaho.di.core.CheckResultInterface;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleStepException;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.core.variables.VariableSpace;
import org.pentaho.di.repository.ObjectId;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.metastore.api.IMetaStore;
import org.w3c.dom.Node;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class WellCoveredStepMetaTest {

	@Mock
	IMetaStore metastore;

	@Mock
	Node stepNode;

	@Mock
	List<DatabaseMeta> databases;

	@Mock 
  TransMeta transMeta;
	
	@Mock
	StepMeta stepMeta;
	
	@Mock 
	StepDataInterface stepDataInterface;
	
	@Mock
	Trans trans;
	
	@Mock
  RowMetaInterface info;

	
	@Mock
  VariableSpace space;
	
	@Mock
  Repository repository;
	
	@Mock
	ObjectId objectId;
	
	WellCoveredStepMeta meta;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		meta = new WellCoveredStepMeta();
	}

	@Test
	public void testClone() throws Exception {		
		WellCoveredStepMeta meta2 = (WellCoveredStepMeta) meta.clone();
		assertNotSame(meta, meta2);
	}

	@Test
	public void testLoadXMLAndSetDefault() throws KettleXMLException {
		meta.loadXML(stepNode, databases, metastore);
		meta.setDefault();
	}

	/*
	 * List<CheckResultInterface> remarks, TransMeta transMeta, StepMeta stepMeta,
	 * RowMetaInterface prev, String input[], String output[], RowMetaInterface
	 * info, VariableSpace space, Repository repository, IMetaStore metaStore
	 */

	@Test
	public void testCheck() {		
		List<CheckResultInterface> remarks = new ArrayList<CheckResultInterface>();

		//StepMeta stepMeta = Mockito.mock(StepMeta.class);
		RowMetaInterface prev = Mockito.mock(RowMetaInterface.class);
		String[] input = { "Some Input Step" };
		String[] output = null;

		meta.check(remarks, transMeta, stepMeta, prev, input, output, info, space, repository, metastore);

		// Test other paths
		when(prev.size()).thenReturn(3);
		input = new String[0];
		meta.check(remarks, transMeta, stepMeta, prev, input, output, info, space, repository, metastore);

	}

	@Test
	public void testGetDialogClassName() {
		assertNotNull(meta.getDialogClassName());		
	}
	
	@Test 
	public void testGetStepData() {
	  assertNotNull(meta.getStepData());	  
	}

	@Test
	public void testGetStep() {
	  when( stepMeta.getName() ).thenReturn( "myStep" );
	  when(transMeta.findStep( "myStep" )).thenReturn(stepMeta);
	  assertNotNull(meta.getStep( stepMeta, stepDataInterface, 0, transMeta, trans ));
	}
	
	@Test 
	public void testReadRep() throws KettleException {
	  meta.readRep( repository, metastore, objectId, databases );
	}
	
	@Test
	public void testSaveRep() throws KettleException {	  
	  meta.saveRep( repository,  metastore, objectId,  objectId );  
	}
	
	@Test
	public void testGetFields() throws KettleStepException {
	  meta.getFields( info, "someName", null, stepMeta, space, repository, metastore);
	}
	 	
}