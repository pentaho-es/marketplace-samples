package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class WellCoveredStepMetaTest {

  @Test
  public void testClone() throws Exception {
    WellCoveredStepMeta meta = new WellCoveredStepMeta();
    WellCoveredStepMeta meta2 = (WellCoveredStepMeta) meta.clone();
    assertNotSame(meta, meta2);
  }

}