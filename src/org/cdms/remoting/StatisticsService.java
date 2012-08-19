/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdms.remoting;

import org.cdms.entities.InvoiceStatView;

/**
 * Defines the functionality to request statistics about <code>Invoice</code>.
 * @author Valery
 */
public interface StatisticsService {
    /**
     * Requests statistics for a given query page object.
     * 
     * @param queryPage the object that contains paging configuration and 
     *    request parameters
     * @return the object of type <code>QueryPage</code> that contains request
     *   results and modified paging info
     * @see org.cdms.entities.InvoiceStatView
     * @see QueryPage
     */
    QueryPage<InvoiceStatView> requestInvoice(QueryPage<InvoiceStatView> queryPage );
}
