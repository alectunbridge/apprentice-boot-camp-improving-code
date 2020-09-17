## When changing existing code…

There are some techniques you can use that allow you to make changes safely

--

## Refactor or rewrite?

+ Manual refactoring still refactoring
+ How does refactor impact client code?
+ Some changes easier as a rewrite of the bad code
+ Replace usages of old code with calls to new code one by one
+ Keeps code functional while you make a complex change
+ Test + commit after each change (mocking is your enemy) 

Notes: Think about it as strangling original code  

--

## If rewriting this way

+ You *must* finish your change (or abort)
+ You *must* delete the original code
+ Otherwise your code is part of the problem

--

## Small chunks

<backgroundimage>https://live.staticflickr.com/4048/4679754721_368012b09e_b.jpg</backgroundimage>
<backgroundimageopacity>0.3</backgroundimageopacity>

+ Commit often, revert on fail, test often
+ Otherwise loose your way during a big refactor
+ Give yourself a safety rope

<p style="font-size: 0.9rem;font-style: italic;"><a href="https://www.flickr.com/photos/54182068@N00/4679754721">"ACC Thursdays Rock Climbing Night - Octopus' Garden wall, Smoke Bluffs near Squamish"</a><span>by <a href="https://www.flickr.com/photos/54182068@N00">iwona_kellie</a></span> is licensed under <a href="https://creativecommons.org/licenses/by/2.0/?ref=ccsearch&atype=html" style="margin-right: 5px;">CC BY 2.0</a><a href="https://creativecommons.org/licenses/by/2.0/?ref=ccsearch&atype=html" target="_blank" rel="noopener noreferrer" style="display: inline-block;white-space: none;opacity: .7;margin-top: 2px;margin-left: 3px;height: 22px !important;"><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc_icon.svg" /><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc-by_icon.svg" /></a></p>

Notes: Climbers use pitons to make sure they don’t fall too far  

--

## Look before you leap

+ Is this tested?
+ Checking coverage

--

## Delete/break code and run the tests

+ Coverage lies
+ Don’t trust tests that haven’t failed
+ Only sure fire way to check code tested
+ Check *why* it fails

--

<backgroundimage>https://live.staticflickr.com/57/219076983_bbd8a3e932_b.jpg</backgroundimage>
<backgroundimageopacity>0.3</backgroundimageopacity>

## Add tests before changing

+ If code uncovered, don’t change it
+ Work out what it is meant to do
+ Add tests that check it does what it is meant to
+ You may find it doesn’t…
+ Then test drive your change

<p style="font-size: 0.9rem;font-style: italic;"><a href="https://www.flickr.com/photos/70534377@N00/219076983">"trapgevel"</a><span>by <a href="https://www.flickr.com/photos/70534377@N00">tuppus</a></span> is licensed under <a href="https://creativecommons.org/licenses/by/2.0/?ref=ccsearch&atype=html" style="margin-right: 5px;">CC BY 2.0</a><a href="https://creativecommons.org/licenses/by/2.0/?ref=ccsearch&atype=html" target="_blank" rel="noopener noreferrer" style="display: inline-block;white-space: none;opacity: .7;margin-top: 2px;margin-left: 3px;height: 22px !important;"><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc_icon.svg" /><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc-by_icon.svg" /></a></p>

--

## Don’t read the comments

+ Comments lie
+ Read them, but be sceptical
+ Comments are a form of duplication
+ Duplication leads to divergence
+ They will erode, particularly in large old code bases

--

<backgroundimage>https://live.staticflickr.com/3342/3308347220_ec8136980c.jpg</backgroundimage>
<backgroundimageopacity>0.1</backgroundimageopacity>

## Be conscious about what you couple to

+ Know where the dragons live
+ Good code must not be tightly coupled to bad code
+ Introduce boundaries
    + Package level boundaries
    + Modular boundaries
    + Codebase boundaries
+ Introduce extension points first to facilitate change

<p style="font-size: 0.9rem;font-style: italic;"><a href="https://www.flickr.com/photos/48034913@N00/3308347220">"Map of Middle Earth"</a><span>by <a href="https://www.flickr.com/photos/48034913@N00">Josh Calvetti</a></span> is licensed under <a href="https://creativecommons.org/licenses/by-nc-nd/2.0/?ref=ccsearch&atype=html" style="margin-right: 5px;">CC BY-NC-ND 2.0</a><a href="https://creativecommons.org/licenses/by-nc-nd/2.0/?ref=ccsearch&atype=html" target="_blank" rel="noopener noreferrer" style="display: inline-block;white-space: none;opacity: .7;margin-top: 2px;margin-left: 3px;height: 22px !important;"><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc_icon.svg" /><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc-by_icon.svg" /><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc-nc_icon.svg" /><img style="height: inherit;margin-right: 3px;display: inline-block;" src="https://search.creativecommons.org/static/img/cc-nd_icon.svg" /></a></p>

--

## Separate style changes from substance

+ Reformat in separate commit
+ Be cautious—reformatting obscures blame
+ IDEs may automatically reformat
    + Review your changes
+ Change the minimum—leave whitespace changes out

--

## Use feature flags to derisk changes

+ Flag can defer risk until rewrite complete
+ Delays integration of new code
+ Test shielded path?