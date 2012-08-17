/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdms.remoting;

import org.cdms.entities.InvoiceStatView;

/**
 *
 * @author Valery
 */
public interface StatisticsService {
    QueryPage<InvoiceStatView> requestInvoice(QueryPage<InvoiceStatView> queryPage );
}
