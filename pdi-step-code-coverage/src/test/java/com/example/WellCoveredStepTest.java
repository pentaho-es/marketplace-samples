package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.step.StepMetaInterface;
import org.pentaho.di.trans.steps.mock.StepMockHelper;
import org.pentaho.di.www.SocketRepository;
import org.pentaho.di.core.logging.LoggingObjectInterface;


public class WellCoveredStepTest {

  WellCoveredStep step;
  
  //private StepMockHelper<WellCoveredStepMeta, WellCoveredStepData> stepMockHelper;
  
  private StepMockHelper<WellCoveredStepMeta, WellCoveredStepData> stepMockHelper;
  
  @Mock
  StepMeta meta;
  
  @Mock
  StepDataInterface stepDataInterface;

  @Mock
  StepMetaInterface stepMetaInterface;

  @Mock
  TransMeta transMeta;
  
  @Mock
  Trans trans;  
  
  
  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    // This is repeated
    when( meta.getName() ).thenReturn( "myStep" );
    when(transMeta.findStep( "myStep" )).thenReturn(meta);

    
    String[] fieldNames = new String[] {"TEST"};
    stepMockHelper = new StepMockHelper<WellCoveredStepMeta, WellCoveredStepData>( "TEST", WellCoveredStepMeta.class, WellCoveredStepData.class );
    when( stepMockHelper.logChannelInterfaceFactory.create( any(), any( LoggingObjectInterface.class ) ) ).thenReturn( stepMockHelper.logChannelInterface );
    when( stepMockHelper.trans.isRunning() ).thenReturn( true );
    when( stepMockHelper.trans.getSocketRepository() ).thenReturn( mock( SocketRepository.class ) );
    //when( stepMockHelper.initStepMetaInterface.getFieldName() ).thenReturn( fieldNames );
    //int[] types = new int[stepMockHelper.initStepMetaInterface.getFieldName().length];
    //when( stepMockHelper.initStepMetaInterface.getAggregateType() ).thenReturn( types );

    
    
    
    step = new WellCoveredStep(meta, stepDataInterface, 1, transMeta, trans);    
  }
  
  @Test
  public void testInit() {    
    step.init( stepMetaInterface, stepDataInterface );    
  }
  
  @Test
  public void testProcessRow() throws KettleException {
    
    when(trans.isRunning()).thenReturn( true );
    
    step.init( stepMetaInterface, stepDataInterface );
    step.setLogLevel( LogLevel.DEBUG );
    step.processRow( stepMockHelper.initStepMetaInterface, stepMockHelper.stepDataInterface);
  }

}
