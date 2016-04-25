# Import the necessary package to process data in JSON format
try:
    import json
except ImportError:
    import simplejson as json

# Import the necessary methods from "twitter" library
from twitter import Twitter, OAuth, TwitterHTTPError, TwitterStream

# Variables that contains the user credentials to access Twitter API 
ACCESS_TOKEN = '162118177-ZHkqkQ8OE5QOOVKw8F0btKXCohwVDNfJDPFiOZnL'
ACCESS_SECRET = 'hQGyKMIDLFZpw5UueZNhKoEjDcHEz1jKK2HpQ4ao5F34k'
CONSUMER_KEY = '1MNc0guRQjioK2LEFzSgH2yvV'
CONSUMER_SECRET = 'zPPqY85aKKQDWIGV94pURwuUG5uCRCbj55zTxLDoaqhY9y4CuG'

oauth = OAuth(ACCESS_TOKEN, ACCESS_SECRET, CONSUMER_KEY, CONSUMER_SECRET)

# Initiate the connection to Twitter Streaming API
twitter_stream = TwitterStream(auth=oauth)

# Get a sample of the public data following through Twitter
iterator = twitter_stream.statuses.sample()

for tweet in iterator:
	tFile = open('tweeta.txt',"a")
	tFile.write(json.dumps(tweet))
# Print each tweet in the stream to the screen 
# Here we set it to stop after getting 1000 tweets. 
# You don't have to set it to stop, but can continue running 
# the Twitter API to collect data for days or even longer. 
#tweet_count = 3200
#for tweet in iterator:
#	print json.dumps(tweet)  
#    text_file = open('tweets.txt','a')
#    text_file.write(tweet)
#    tweet_count -= 1
# Twitter Python Tool wraps the data returned by Twitter 
# as a TwitterDictResponse object.
# We convert it back to the JSON format to print/score
# The command below will do pretty printing for JSON data, try it out
# print json.dumps(tweet, indent=4)
   
#    if tweet_count <= 0:
#        break 