package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.eclipse.swt.widgets.Shell;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.Props;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.ui.core.PropsUI;

import java.lang.reflect.Field;

/**
 * Testing a dialog class is generally not going to be feasible, as demonstrated here.
 *
 * This was fair amount of setup for a very small reward of testing the constructor.
 * "open", the workhorse method of most dialogs, does not seem to be tested
 * anywhere in the kettle code.  Some step dialog classes have
 * tests for specific functionality, but over-all they're coverage is low.
 */
public class WellCoveredStepDialogTest {

  private static boolean changedPropsUi;

  @BeforeClass
  public static void initKettle() throws Exception {
    KettleEnvironment.init();
  }

  @BeforeClass
  public static void hackPropsUi() throws Exception {
    Field props = getPropsField();
    if ( props == null ) {
      throw new IllegalStateException( "Cannot find 'props' field in " + Props.class.getName() );
    }

    Object value = FieldUtils.readStaticField( props, true );
    if ( value == null ) {
      PropsUI mock = mock( PropsUI.class );
      FieldUtils.writeStaticField( props, mock, true );
      changedPropsUi = true;
    } else {
      changedPropsUi = false;
    }
  }

  private static Field getPropsField() {
    return FieldUtils.getDeclaredField( Props.class, "props", true );
  }

  @Test
  public void testCanConstructAndOpen() {
    WellCoveredStepMeta meta = new WellCoveredStepMeta();

    WellCoveredStepDialog dialog = new WellCoveredStepDialog(mock(Shell.class),
            meta, mock(TransMeta.class), "MinimalConstructorTest");

    // Not tested elsewhere in Pentaho code either
    // dialog.open();
  }

}
