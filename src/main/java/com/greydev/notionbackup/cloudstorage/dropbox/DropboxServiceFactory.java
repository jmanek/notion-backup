package com.greydev.notionbackup.cloudstorage.dropbox;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.v2.DbxClientV2;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DropboxServiceFactory {

	public static Optional<DbxClientV2> create(String dropboxAccessToken, String dropboxRefreshToken, String dropboxAppKey, String dropboxAppSecret) {
		DbxClientV2 service = null;
		DbxCredential credential = null;
		try {
			credential = new DbxCredential(dropboxAccessToken, -1L, dropboxRefreshToken, dropboxAppKey, dropboxAppSecret);
			DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/notion-backup").build();
			service = new DbxClientV2(config, credential);
		} catch (Exception e) {
			log.warn("An exception occurred: ", e);
		}
		return Optional.ofNullable(service);
	}
}
