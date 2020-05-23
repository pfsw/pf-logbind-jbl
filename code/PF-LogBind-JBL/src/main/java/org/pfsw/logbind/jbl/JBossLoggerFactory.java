// ===========================================================================
// CONTENT  : CLASS JBossLoggerFactory
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 18/05/2020
// HISTORY  :
//  18/05/2020  mdu  CREATED
//
// Copyright (c) 2020, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.logbind.jbl;

import org.pfsw.logging.Logger;
import org.pfsw.logging.LoggerFactory;

/**
 * This factory can be registered with the PF logging framework to support
 * binding of all PF logging output to JBoss Logging (JBL) loggers.
 * <p>
 * In order to activate the binding, this library must be on the classpath
 * and system property <strong>org.pfsw.logging.binding=JBL</strong> set.  
 *
 * @author Manfred Duchrow
 * @version 1.0
 */
public class JBossLoggerFactory implements LoggerFactory
{
  public JBossLoggerFactory()
  {
    super();
  }

  @Override
  public String getName()
  {
    return "JBL";
  }

  @Override
  public Logger createLogger()
  {
    return getLogger("");
  }

  @Override
  public Logger getLogger(Class<?> clazz)
  {
    return new JBossLoggerAdapter(clazz);
  }

  @Override
  public Logger getLogger(String loggerName)
  {
    return new JBossLoggerAdapter(loggerName);
  }
}
