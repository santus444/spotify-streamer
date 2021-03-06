package com.santoshmandadi.spotifystreamer.app.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by santosh on 7/28/15.
 */
public class SpotifyContract {
    public static final String CONTENT_AUTHORITY = "com.santoshmandadi.spotifystreamer.app";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_ARTISTS = "artists";

    public static final String PATH_TOPTRACKS = "toptracks";

    public static final String PATH_TRACK = "track";

    public static final class TopTracksEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOPTRACKS).build();
        public static final Uri TRACK_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOPTRACKS).appendPath(PATH_TRACK).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOPTRACKS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOPTRACKS;

        public static final String TABLE_NAME = "toptracks";

        public static final String COLUMN_ARTIST_ID = "artist_id";

        public static final String COLUMN_ALBUM_NAME = "album_name";

        public static final String COLUMN_TRACK_NAME = "track_name";

        public static final String COLUMN_SMALL_ALBUM_IMAGE = "small_album_image";

        public static final String COLUMN_LARGE_ALBUM_IMAGE = "large_album_image";

        public static final String COLUMN_TRACK_PREVIEW_URL = "preview_url";

        public static Uri buildTopTracksUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildTopTracksUriWithArtistId(String id) {
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static Uri buildTrackUriWithArtistIdAndPosition(String id, int position) {
            return ContentUris.withAppendedId(CONTENT_URI.buildUpon().appendPath(id).build(), position);
        }

        public static Uri buildTrackUriWithRowId(long id) {
            return ContentUris.withAppendedId(TRACK_URI, id);
        }

        public static String getArtistIdFromTopTracksUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static String getArtistIdFromTrackUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static int getPositionFromTrackUri(Uri uri) {
            return Integer.parseInt(uri.getPathSegments().get(2));
        }
    }

    public static final class ArtistsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ARTISTS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ARTISTS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ARTISTS;

        public static final String TABLE_NAME = "artists";

        public static final String COLUMN_ARTIST_ID = "artist_id";

        public static final String COLUMN_ARTIST_NAME = "artist_name";

        public static final String COLUMN_ARTIST_IMAGE = "artist_image";

        public static Uri buildArtistsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }


}
