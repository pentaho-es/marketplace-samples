package com.example;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pentaho.di.trans.step.BaseStepMeta;
import org.pentaho.metaverse.api.IMetaverseNode;
import org.pentaho.metaverse.api.MetaverseAnalyzerException;


public class WellCoveredStepStepAnalyzerTest {

  WellCoveredStepStepAnalyzer analyzer;
  
  @Mock
  WellCoveredStepMeta meta;
  
  @Mock
  IMetaverseNode rootNode;
  
  @Before
  public void before() {
    analyzer = new WellCoveredStepStepAnalyzer();   
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void testGetUsedFields() {
    // This should be assertNotNull, etc., when analyzer is implemented
    assertNull(analyzer.getUsedFields(meta));           
  }
  
  // Could assert the "do_nothing" behavior, but better to flesh this 
  // out when class is implemented
  @Test
  public void testCustomAnalyze() throws MetaverseAnalyzerException {    
    analyzer.customAnalyze( meta, rootNode );
  }
  
  @Test 
  public void testGetSupportedSteps() {
    Set<Class<? extends BaseStepMeta>> steps = analyzer.getSupportedSteps();
    assertTrue( steps.contains( WellCoveredStepMeta.class ));
  }
}
