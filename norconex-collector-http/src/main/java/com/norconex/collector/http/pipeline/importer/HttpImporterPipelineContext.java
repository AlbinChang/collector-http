/* Copyright 2010-2014 Norconex Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.norconex.collector.http.pipeline.importer;

import org.apache.http.client.HttpClient;

import com.norconex.collector.core.data.store.ICrawlDataStore;
import com.norconex.collector.core.pipeline.importer.ImporterPipelineContext;
import com.norconex.collector.http.crawler.HttpCrawler;
import com.norconex.collector.http.crawler.HttpCrawlerConfig;
import com.norconex.collector.http.data.HttpCrawlData;
import com.norconex.collector.http.doc.HttpDocument;
import com.norconex.collector.http.doc.HttpMetadata;
import com.norconex.collector.http.fetch.IHttpMetadataFetcher;
import com.norconex.collector.http.robot.RobotsMeta;
import com.norconex.collector.http.sitemap.ISitemapResolver;
import com.norconex.importer.Importer;

/**
 * @author Pascal Essiembre
 *
 */
public class HttpImporterPipelineContext extends ImporterPipelineContext {

    private RobotsMeta robotsMeta;
    
    public HttpImporterPipelineContext(
            HttpCrawler crawler, ICrawlDataStore crawlDataStore, 
            HttpCrawlData crawlData, HttpDocument doc) {
        super(crawler, crawlDataStore, crawlData, doc);
    }

    public HttpCrawler getCrawler() {
        return (HttpCrawler) super.getCrawler();
    }

    public HttpCrawlerConfig getConfig() {
        return getCrawler().getCrawlerConfig();
    }
    
    public HttpCrawlData getCrawlData() {
        return (HttpCrawlData) super.getCrawlData();
    }
    
    public HttpClient getHttpClient() {
        return getCrawler().getHttpClient();
    }

    public HttpDocument getDocument() {
        return (HttpDocument) super.getDocument();
    }

    public IHttpMetadataFetcher getHttpHeadersFetcher() {
        return getConfig().getMetadataFetcher();
    }

    public ISitemapResolver getSitemapResolver() {
        return getCrawler().getSitemapResolver();
    }
    
    public HttpMetadata getMetadata() {
        return getDocument().getMetadata();
    }
    
    public Importer getImporter() {
        return getCrawler().getImporter();
    }

    public RobotsMeta getRobotsMeta() {
        return robotsMeta;
    }
    /**
     * @param robotsMeta the robotsMeta to set
     */
    public void setRobotsMeta(RobotsMeta robotsMeta) {
        this.robotsMeta = robotsMeta;
    }

    public boolean isHttpHeadFetchEnabled() {
        return getConfig().getMetadataFetcher() != null;
    }
    
}
              